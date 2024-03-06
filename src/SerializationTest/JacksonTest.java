//package SerializationTest;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.*;
//import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
//import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
//import com.fasterxml.jackson.databind.ser.SerializerFactory;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//
//public class JacksonTest {
//
//    public static void main(String[] args) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.registerModule(new JavaTimeModule());
////        mapper.setSerializerFactory(new CustomBeanSerializerFactory(null));
//        People people = new People(0,"Kim",LocalDateTime.now());
//        people.getPeopleList().add(new People(0,"Kim2",LocalDateTime.now()));
//        people.getPeopleList().add(new People(0,"Kim3",LocalDateTime.now()));
//        String json = mapper.writeValueAsString(people);
//        System.out.println(json.toString());
//        People people2 = mapper.readValue(json,People.class);
//        System.out.println(people2);
//    }
//
//
//    static class CustomBeanSerializerFactory extends BeanSerializerFactory{
//        private final LocalDateTimeSerializer localDateTimeSerializer =
//                new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        protected CustomBeanSerializerFactory(SerializerFactoryConfig config) {
//            super(config);
//        }
//        // java 의 인스턴스를 json 형태의 text 로 변활할때 찾는 객체로써, jackson 은 각 타입마다 내부적으로 갖고 있는 JsonSerializer 가 존재하는데,
//        // java 8 이전 버전의 호환성을 유지하기 위해 java.time 하위 클래스들은 JsonSerializer 를 별도로 갖고 있지 않아 에러가 발생, 그래서 별도로 JsonSerializer 를 생성해서 넣어줌
//        // jackson-datatype-jsr310 ( JavaTimeModule ) 모듈을 사용하여도 java.time 하위 패키지에 존재하는 클래스 타입을 직렬화 할 수 있음
//        @Override
//        protected JsonSerializer<?> _findUnsupportedTypeSerializer(SerializerProvider ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
//            if (type.getRawClass() == LocalDateTime.class) {
//                return localDateTimeSerializer;
//            }
//            return null;
//        }
//        @Override
//        public SerializerFactory withConfig(SerializerFactoryConfig config) {
//            if (_factoryConfig == config) return this;
//            return new CustomBeanSerializerFactory(config);
//        }
//    }
//
//    static class People{
//        private int age;
//        private String name;
//        private LocalDateTime birthDay;
//        private List<People> peopleList = new ArrayList<>();
//
//        public People() {
//        }
//
//        People(int age, String name, LocalDateTime birthDay){
//            this.age = age;
//            this.name = name;
//            this.birthDay = birthDay;
//        }
//        public List<People> getPeopleList() {
//            return peopleList;
//        }
//        public int getAge(){
//            return this.age;
//        }
//        public String getName(){
//            return this.name;
//        }
//        public LocalDateTime getBirthDay(){
//            return this.birthDay;
//        }
//
//        public void setAge(int age) {
//            this.age = age;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public void setBirthDay(LocalDateTime birthDay) {
//            this.birthDay = birthDay;
//        }
//
//        public void setPeopleList(List<People> peopleList) {
//            this.peopleList = peopleList;
//        }
//
//        @Override
//        public String toString() {
//            return "People{" +
//                    "age=" + age +
//                    ", name='" + name + '\'' +
//                    ", birthDay=" + birthDay +
//                    ", peopleList=" + peopleList.toString() +
//                    '}';
//        }
//    }
//}
