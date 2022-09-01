package com.team3.fooddeliverybackend.controller;

import com.team3.fooddeliverybackend.base.BaseComponent;
import com.team3.fooddeliverybackend.domain.BaseModel;
import com.team3.fooddeliverybackend.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class BaseController<T extends BaseModel> extends BaseComponent {

    protected abstract BaseService<T> getBaseService();

    @GetMapping("/{id}")
    public ResponseEntity<T> get(@PathVariable("id") final Long id) {
        return ResponseEntity.ok(getBaseService().get(id));
    }

    @GetMapping
    public ResponseEntity<List<T>> findAll() {
        return ResponseEntity.ok().body(getBaseService().findAll());
    }

    @PostMapping
    public ResponseEntity<T> create(@Valid @RequestBody final T entity) {
        return new ResponseEntity<>((getBaseService().create(entity)),
                HttpStatus.CREATED);
    }
    @PostMapping(headers = "list")
    public ResponseEntity<List<T>>createAll(@Valid @RequestBody List<T> entities) {
        return new ResponseEntity<>(getBaseService().createAll(entities),
                HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody final T entity) {
        getBaseService().update(entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
        getBaseService().deleteById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @RequestBody final T entity) {
        if (getBaseService().exists(entity)) {
            getBaseService().delete(entity);
        }
    }
}
