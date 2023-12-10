package com.example.carservice2.mapper;

public interface Mapper<M, D> {
    M toModel(D dto);
    D toDTO(M model);
}
