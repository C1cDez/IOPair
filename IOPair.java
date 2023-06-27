package com.cicdez.test;

import java.io.*;

public class IOPair<I extends InputStream, O extends OutputStream> {
    private final I input;
    private final O output;

    public IOPair(I input, O output) {
        this.input = input;
        this.output = output;
    }

    public I getInput() {
        return input;
    }
    public O getOutput() {
        return output;
    }

    public DataIOPair<DataInput, DataOutput> getDataIO() {
        return new DataIOPair<>(new DataInputStream(input), new DataOutputStream(output));
    }
    public RWPair<Reader, Writer> getRWPair() {
        return new RWPair<>(new InputStreamReader(input), new OutputStreamWriter(output));
    }

    public static class RWPair<R extends Reader, W extends Writer> {
        private final R reader;
        private final W writer;

        public RWPair(R reader, W writer) {
            this.reader = reader;
            this.writer = writer;
        }

        public R getReader() {
            return reader;
        }
        public W getWriter() {
            return writer;
        }
    }

    public static class DataIOPair<DI extends DataInput, DO extends DataOutput> {
        private final DI input;
        private final DO output;

        public DataIOPair(DI input, DO output) {
            this.input = input;
            this.output = output;
        }

        public DI getInput() {
            return input;
        }
        public DO getOutput() {
            return output;
        }
    }
}
