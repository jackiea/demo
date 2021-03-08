package com.youkol.designpattern.strategy;

import java.util.ArrayList;
import java.util.List;

public class Share {
    private static List<ShareStrategyContext> contexts = new ArrayList<>();

    static {
        contexts.add(new ShareStrategyContext("Weibo", new WeiboShareStrategy()));
        contexts.add(new ShareStrategyContext("Wechat", new WechatShareStrategy()));
    }

    public void share(final String type) {
        contexts.stream()
            .filter(t -> t.support(type))
            .map(ShareStrategyContext::getStrategy)
            .findFirst()
            .ifPresent(t -> t.share(type));
    }
}
