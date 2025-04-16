package com.example.preparationapp;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@EnableKafkaStreams
public class StreamProcessor {
    /**
     * Definicja topologii Kafka Streams:
     * Pobiera dane z `input-topic`, przetwarza je i zapisuje do `output-topic`.
     */
    @Bean
    public KStream<String, String> kStream(StreamsBuilder streamsBuilder) {
        // Pobieramy strumień danych z tematu "input-topic"
        KStream<String, String> inputStream = streamsBuilder.stream("input-topic");

        // Przetwarzane wiadomości: zamieniamy wartości na wielkie litery
        KStream<String, String> transformedStream = inputStream.mapValues(value -> value.toUpperCase(Locale.ROOT));

        // Wynik: zapisujemy dane do "output-topic"
        transformedStream.to("output-topic");

        // Zwrot domyślnego strumienia
        return inputStream;
    }

}
