package com.youkol.designpattern.demo2;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
public class HandlerService {
    Map<HandleType, Handler> map = new EnumMap<>(HandleType.class);

    public HandlerService() {
        map.put(HandleType.CONNECT, new ConnectHandler());
        map.put(HandleType.DISCONNECT, new DisConnectHandler());
    }

    public HandlerService(ObjectProvider<Handler> handler) {
        List<Handler> handlers = handler.orderedStream().collect(Collectors.toList());
        handlers.forEach(t -> map.put(t.getType(), t));
    }

    public void handle(HandleType type, String message) {
        map.get(type).handle(message);
    }

}
