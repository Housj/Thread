package InstrumentDemo;


import org.objectweb.asm.ClassReader;

import java.io.RandomAccessFile;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;

/**
 * @author sergei
 * @create 2020-03-18
 */
public class AgentMain {

    /**
     * @param agentArgs 外部传入的参数，类似于 main 函数 args
     * @param inst
     */
    public static void agentmain(String agentArgs, Instrumentation inst){
        // 从 agentArgs 获取外部参数
        System.out.println("开始热更新");
        // 这里将会传入 class 文件路径
        String path = agentArgs;
        try {
            // 读取 class 文件字节码
            RandomAccessFile f = new RandomAccessFile(path,"r");
            final byte[] bytes = new byte[(int)f.length()];
            f.readFully(bytes);
            // 使用 asm 框架获取类名
            final String className = readClassName(bytes);

            // inst.getAllLoadedClasses 方法将会获取所有已加载的 class
            for (Class clazz : inst.getAllLoadedClasses()) {
                // 匹配需要替换 class
                if (clazz.getName().equals(className)) {
                    ClassDefinition definition = new ClassDefinition(clazz, bytes);
                    // 使用指定的 class 替换当前系统正在使用 class
                    inst.redefineClasses(definition);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 使用 asm 读取类名
     * @param bytes
     * @return
     */
    private static String readClassName(final byte[] bytes) {
        return new ClassReader(bytes).getClassName().replace("/", ".");
    }
}
