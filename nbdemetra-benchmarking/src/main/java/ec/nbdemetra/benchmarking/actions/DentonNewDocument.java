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
package ec.nbdemetra.benchmarking.actions;

import ec.tss.disaggregation.documents.DentonDocument;
import ec.nbdemetra.benchmarking.DentonDocumentManager;
import ec.nbdemetra.ws.Workspace;
import ec.nbdemetra.ws.WorkspaceFactory;
import ec.nbdemetra.ws.WorkspaceItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Window",
        id = "ec.nbdemetra.benchmarking.actions.DentonNewDocument"
)
@ActionRegistration(
        displayName = "#CTL_DentonNewDocument"
)
@ActionReferences({
    @ActionReference(path = "Menu/Statistical methods/Benchmarking", name="New", position = 1000)
})
@Messages("CTL_DentonNewDocument=Denton")
public final class DentonNewDocument implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        DentonDocumentManager mgr = WorkspaceFactory.getInstance().getManager(DentonDocumentManager.class);
        if (mgr != null) {
            Workspace ws = WorkspaceFactory.getInstance().getActiveWorkspace();
            WorkspaceItem<DentonDocument> ndoc = mgr.create(ws);
            mgr.openDocument(ndoc);
        }
    }
}
