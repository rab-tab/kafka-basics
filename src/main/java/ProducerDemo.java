import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerDemo {
    public static void main(String[] args) {
        String bootstrapServers="127.0.0.1:9092";
        //producer properties
        Properties config = new Properties();
        config.put("bootstrap.servers", bootstrapServers);
        config.setProperty("key.serializer", StringSerializer.class.getName());
        config.setProperty("value.serializer", StringSerializer.class.getName());

        //create producer
        KafkaProducer<String,String> producer=new KafkaProducer<String, String>(config);
        //create producer record
        ProducerRecord<String,String> record=new ProducerRecord<String,String>("first_topic","hello_world");

        //send data - this is async
        producer.send(record);
        producer.flush();
        producer.close();


    }
}
