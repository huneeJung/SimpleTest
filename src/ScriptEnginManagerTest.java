import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptEnginManagerTest {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("JavaScript");
        //engine.eval("console.log('Test')"); console.log 는 브라우저에서 동작하므로 에러 발생
        // print 는 ScriptEngine 이 제공하는 것으로, 자바의 System.print 를 사용하여 스크립트에서 실행한 데이터를 자바의 콘솔에 출력
        engine.eval("" +
                "var ab = 20; "+
                "var cd = 30; "+
                "print(ab+cd)");
    }
}
