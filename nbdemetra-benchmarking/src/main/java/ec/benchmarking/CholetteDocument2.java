/*
 * Copyright 2013 National Bank of Belgium
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they will be approved 
 * by the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * http://ec.europa.eu/idabc/eupl
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and 
 * limitations under the Licence.
 */
package ec.benchmarking;

import ec.tss.Ts;
import ec.tss.disaggregation.documents.BenchmarkingResults;
import ec.tss.disaggregation.documents.UniCholetteSpecification;
import ec.tss.disaggregation.processors.CholetteProcessor;
import ec.tss.documents.MultiTsDocument;
import ec.tstoolkit.algorithm.ProcessingContext;

/**
 *
 * @author Jean Palate
 */
public class CholetteDocument2 extends MultiTsDocument2<UniCholetteSpecification, BenchmarkingResults> {

    public CholetteDocument2() {
        super(CholetteProcessor.instance);
        setSpecification(new UniCholetteSpecification());
    }

    public CholetteDocument2(ProcessingContext context) {
        super(CholetteProcessor.instance, context);
        setSpecification(new UniCholetteSpecification());
    }

    @Override
    public void setInput(Ts[] s) {
        if (s != null && s.length != 2) {
            throw new IllegalArgumentException("Cholette requires 2 time series");
        }
        super.setInput(s);
    }
}