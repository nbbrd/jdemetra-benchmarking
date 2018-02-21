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
package ec.nbdemetra.benchmarking;

import ec.benchmarking.CholetteDocument2;
import ec.nbdemetra.ws.DefaultFileItemRepository;
import ec.nbdemetra.ws.IWorkspaceItemRepository;
import ec.nbdemetra.ws.WorkspaceItem;
import ec.tstoolkit.MetaData;
import internal.workspace.file.CholetteDocHandler;
import java.util.Date;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author palatej
 */
@ServiceProvider(service = IWorkspaceItemRepository.class)
public final class CholetteDocFileRepository extends DefaultFileItemRepository<CholetteDocument2> {

    @Deprecated
    public static final String REPOSITORY = CholetteDocHandler.REPOSITORY;

    @Override
    public String getRepository() {
        return REPOSITORY;
    }

    @Override
    public boolean load(WorkspaceItem<CholetteDocument2> item) {
        return loadFile(item, (CholetteDocument2 o) -> {
            item.setElement(o);
            item.resetDirty();
        });
    }

    @Override
    public boolean save(WorkspaceItem<CholetteDocument2> item) {
        CholetteDocument2 element = item.getElement();
        element.getMetaData().put(MetaData.DATE, new Date().toString());
        return storeFile(item, element, item::resetDirty);
    }

    @Override
    public boolean delete(WorkspaceItem<CholetteDocument2> doc) {
        return deleteFile(doc);
    }

    @Override
    public Class<CholetteDocument2> getSupportedType() {
        return CholetteDocument2.class;
    }
}
