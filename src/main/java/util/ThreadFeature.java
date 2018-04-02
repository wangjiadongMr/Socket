package util;

import java.util.concurrent.*;

/**
 * @author wang
 * @data on 2018/3/30
 */
public class ThreadFeature<V>  extends FutureTask<V>{


    public ThreadFeature(Callable callable) {
        super(callable);
    }

    public ThreadFeature(Runnable runnable, V result) {
        super(runnable, result);
    }

}
