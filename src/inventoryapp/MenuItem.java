/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package inventoryapp;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;

/**
 *
 * @author zero
 */



public class MenuItem extends javax.swing.JPanel {

    /**
     * @return the subMenu
     */
    public ArrayList<MenuItem> getSubMenu() {
        return subMenu;
    }
    private final ArrayList<MenuItem> subMenu = new ArrayList<>();
    private ActionListener act;
    /**
     * Creates new form MenuItem
     * @param icon
     * @param sbm
     * @param iconSub
     * @param menuName
     * @param act
     * @param subMenu
     */
    public MenuItem(Icon icon, boolean sbm, Icon iconSub, String menuName, ActionListener act, MenuItem... subMenu) {
        initComponents();
        
        lb_icon.setIcon(icon);
        lb_iconSub.setIcon(iconSub);
        lb_menuName.setText(menuName);
        lb_iconSub.setVisible(sbm);
        
        
        if(act != null){
            this.act = act;
        }
        
        this.setSize(new Dimension(Integer.MAX_VALUE,45));
        this.setMinimumSize(new Dimension(Integer.MAX_VALUE,45));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE,45));
        
        for (int i = 0; i < subMenu.length; i++) {
            this.subMenu.add(subMenu[i]);
            subMenu[i].setVisible(false);
            
        }
        
        
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_menuName = new javax.swing.JLabel();
        lb_iconSub = new javax.swing.JLabel();
        lb_icon = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        lb_menuName.setBackground(new java.awt.Color(51, 51, 51));
        lb_menuName.setFont(new java.awt.Font("NATS", 0, 15)); // NOI18N
        lb_menuName.setForeground(new java.awt.Color(255, 255, 255));
        lb_menuName.setText("Menu Item...");

        lb_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_iconSub, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_menuName, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_menuName, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(lb_iconSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private boolean showing=false;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
  
        // TODO add your handling code here:
        if(showing){
            hideMenu();
        }else{
            showMenu();
        }
        if(act !=null){
            act.actionPerformed(null);
        }
        
        
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_icon;
    private javax.swing.JLabel lb_iconSub;
    private javax.swing.JLabel lb_menuName;
    // End of variables declaration//GEN-END:variables

    private void hideMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <getSubMenu().size(); i++) {
                    sleep();
                    getSubMenu().get(i).setVisible(false);
                    
                }
                showing= false;
                getParent().repaint();
                getParent().revalidate();
            }
        }).start();
    }

    private void showMenu() {
         new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <getSubMenu().size(); i++) {
                    sleep();
                    getSubMenu().get(i).setVisible(true);
                    
                }
                showing= true;
                getParent().repaint();
                getParent().revalidate();
            }
        }).start();
    }
    private void sleep(){
        try{
            Thread.sleep(20);
        }catch(Exception e){
            
        }
    }
}
