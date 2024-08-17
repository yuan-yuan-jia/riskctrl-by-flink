package com.jyy.riskctrl.flink;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.operators.StreamFlatMap;
import org.apache.flink.streaming.util.KeyedOneInputStreamOperatorTestHarness;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/*
  Flink流处理算子单元测试
 */
public class StreamTest {

    @DisplayName("无状态计算的单元测试")
    @Test
    public void testNoStateful() throws Exception {
        TestMapFunction statelessMap = new TestMapFunction();
        String out = statelessMap.map("world");
        // 打印
        System.out.println(out);
        // 断言
        Assertions.assertEquals("hello world", out);
    }

    @DisplayName("有状态计算的单元测试")
    @Test
    public void testStateful() throws Exception {

        try (KeyedOneInputStreamOperatorTestHarness<
                String,
                Tuple2<String, Integer>,
                Tuple2<String, Integer>
                > testHarness = new KeyedOneInputStreamOperatorTestHarness<>(
                new StreamFlatMap<>(new TestStateful()),
                x -> x.f0,
                Types.STRING
        )) {

            testHarness.open();
            // 模拟数据
            //第一条数据
            testHarness.processElement(Tuple2.of("hadoop", 1), 1);
            testHarness.processElement(Tuple2.of("hadoop", 4), 2);

            System.out.println(testHarness.extractOutputValues());

            Assertions.assertEquals(testHarness.extractOutputValues(),
                    Arrays.asList(Tuple2.of("hadoop", 1), Tuple2.of("hadoop", 5))
            );
        }
    }


}
