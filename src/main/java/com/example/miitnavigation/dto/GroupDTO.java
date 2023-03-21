package com.example.miitnavigation.dto;

public record GroupDTO(long id, String groupName) {
    @Override
    public String toString() {
        return "GroupDTO{" +
                "groupName='" + groupName + '\'' +
                '}';
    }
}
