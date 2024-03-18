package org.example.appender;

import ch.qos.logback.core.UnsynchronizedAppenderBase;
import ch.qos.logback.core.encoder.Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAppender<E> extends UnsynchronizedAppenderBase<E> {

    private Encoder encoder;

    public void setEncoder(Encoder encoder) {
        this.encoder = encoder;
    }

    @Override
    protected void append(E e) {
        byte[] byteArray = this.encoder.encode(e);
        String string = new String(byteArray);
        System.out.print(string);
    }

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(MyAppender.class);
        logger.info("hello world");
    }

}
