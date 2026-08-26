package ru.practicum.ewm.mapper;

import ru.practicum.ewm.EndpointHitRequestDto;
import ru.practicum.ewm.model.Hit;

public final class HitMapper {

    private HitMapper() {
    }

    public static Hit toHit(EndpointHitRequestDto hitDto) {
        Hit hit = new Hit();
        hit.setApp(hitDto.getApp());
        hit.setUri(hitDto.getUri());
        hit.setIp(hitDto.getIp());
        hit.setTimestamp(hitDto.getTimestamp());
        return hit;
    }
}
