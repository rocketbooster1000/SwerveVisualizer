package root.util;

import java.awt.event.ActionEvent;

@FunctionalInterface
public interface ActionPerformable {
    public void actionPerformed(ActionEvent e);
}
