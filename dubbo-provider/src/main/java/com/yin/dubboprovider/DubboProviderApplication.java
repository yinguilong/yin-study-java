package com.yin.dubboprovider;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.yin.api.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DubboProviderApplication {

    public static void main(String[] args) {
        initRules();
        SpringApplication.run(DubboProviderApplication.class, args);
    }

    public static void initRules() {
        List<FlowRule> flowRuleList = new ArrayList<>();
        FlowRule rule = new FlowRule(DemoService.class.getName());
        rule.setCount(11);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRuleList.add(rule);
        FlowRuleManager.loadRules(flowRuleList);
    }
}

