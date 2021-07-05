package org.sidorov.processing;

import org.sidorov.input.Input;
import org.sidorov.output.Output;
import org.sidorov.processor.ProcessorInterface;

import java.util.List;

public abstract class ProcessingAbstract implements ProcessingInterface {

    protected Input input;
    protected Output output;
    protected ProcessorInterface processor;

    @Override
    public void setIO(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void setProcessor(ProcessorInterface processor) {
        this.processor = processor;
    }

    @Override
    public boolean validation(List<String> list) {
        if (input == null || output == null || processor == null) {
            throw new NullPointerException("You need init input or output or processor object");
        }
        if (list.size() != 3) {
            throw new ArrayStoreException("Inter only three symbols");
        }
        return true;
    }

    @Override
    public List<String> preparing(String line) throws Exception {
        return null;
    }

    @Override
    public void processing() {

    }
}
