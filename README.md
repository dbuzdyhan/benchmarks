# benchmarks
Run it in terminal 
./gradlew clean jmh --no-daemon

Memory 15.5 GiB
Processor Intel® Core™ i7-7700HQ CPU @ 2.80GHz × 8 
Graphic Intel® HD Graphics 630 (Kaby Lake GT2)

Result "com.jsonparser.JsonParserTest.jackson":
  37.638 ±(99.9%) 1.703 ms/op [Average]
  (min, avg, max) = (34.452, 37.638, 42.982), stdev = 2.274
  CI (99.9%): [35.935, 39.342] (assumes normal distribution)

Result "com.jsonparser.JsonParserTest.gson":
  38.994 ±(99.9%) 1.096 ms/op [Average]
  (min, avg, max) = (37.363, 38.994, 42.087), stdev = 1.463
  CI (99.9%): [37.898, 40.091] (assumes normal distribution)


Benchmark               Mode  Cnt   Score   Error  Units
JsonParserTest.gson     avgt   25  38.994 ± 1.096  ms/op
JsonParserTest.jackson  avgt   25  37.638 ± 1.703  ms/op


jmh group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.9.9'
jmh group: 'com.google.code.gson', name: 'gson', version: '2.8.5'