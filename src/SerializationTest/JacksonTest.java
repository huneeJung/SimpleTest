package SerializationTest;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JacksonTest {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializerFactory(new CustomBeanSerializerFactory(null));
        People people = new People(0,"Kim",LocalDateTime.now());
        people.getPeopleList().add(new People(0,"Kim2",LocalDateTime.now()));
        people.getPeopleList().add(new People(0,"Kim3",LocalDateTime.now()));
        JsonNode json = mapper.valueToTree(people);
        System.out.println(json.toString());
    }


    static class CustomBeanSerializerFactory extends BeanSerializerFactory{
        private final LocalDateTimeSerializer localDateTimeSerializer =
                new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        protected CustomBeanSerializerFactory(SerializerFactoryConfig config) {
            super(config);
        }
        protected JsonSerializer<?> _findUnsupportedTypeSerializer(SerializerProvider ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
            if (type.getRawClass() == LocalDateTime.class) {
                return localDateTimeSerializer;
            }
            return null;
        }
        @Override
        public SerializerFactory withConfig(SerializerFactoryConfig config) {
            if (_factoryConfig == config) return this;
            return new CustomBeanSerializerFactory(config);
        }
    }

    static class People{
        private int age;
        private String name;
        private LocalDateTime birthDay;
        private List<People> peopleList = new ArrayList<>();

        People(int age,String name,LocalDateTime birthDay){
            this.age = age;
            this.name = name;
            this.birthDay = birthDay;
        }
        public List<People> getPeopleList() {
            return peopleList;
        }
        public int getAge(){
            return this.age;
        }
        public String getName(){
            return this.name;
        }
        public LocalDateTime getBirthDay(){
            return this.birthDay;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setBirthDay(LocalDateTime birthDay) {
            this.birthDay = birthDay;
        }

        public void setPeopleList(List<People> peopleList) {
            this.peopleList = peopleList;
        }
    }
}
