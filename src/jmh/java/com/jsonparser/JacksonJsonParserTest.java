package com.jsonparser;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(value = TimeUnit.MILLISECONDS)
public class JacksonJsonParserTest {
    private ObjectMapper objectMapper;
    private String json;

    @Setup
    public void setUp() {
        this.objectMapper = new ObjectMapper();
        this.json = prepareJsonString();
    }

    @Benchmark
    public Map<String, Object> test() throws IOException {
        return objectMapper.readValue(json, Map.class);
    }

    private String prepareJsonString() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("reports_data_by_ids.json");
            return new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));
        } catch (Exception e) { // covered by unit test
            return null;
        }
    }
}
