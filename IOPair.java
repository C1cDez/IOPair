package com.cicdez.infocoder;

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

    public void push() throws IOException {
        output.write(input.read());
    }

    public DataIOPair<DataInput, DataOutput> getDataIO() {
        return new DataIOPair<>(new DataInputStream(input), new DataOutputStream(output));
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
