/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Graph.java
 *
 * Created on 27.04.2011, 12:01:48
 */
package elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author max
 */
public class Graph extends javax.swing.JPanel {


    
    private class P2D{
        public int x;
        public int y;
        
        public P2D(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static final int STYLE_LINES = 0;
    public static final int STYLE_RECTS = 1;
    
    private List<Float> data = null;
    private Color graphColor = Color.GREEN;
    private Color graphBgColor = Color.black;
    private double targetValue;
    private int style = STYLE_LINES;
    private int steps;

    public void setSteps(int steps)
    {
        this.steps = steps;
    }

    private float min;
    private float max = -1;

    public Graph setMax(float max)
    {
        this.max = max;
        return this;
    }

    public Graph setMin(float min)
    {
        this.min = min;
        return this;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public void setTargetValue(double targetValue) {
        this.targetValue = targetValue;
    }

    public void setGraphBgColor(Color graphBgColor) {
        this.graphBgColor = graphBgColor;
        setBackground(graphBgColor);
    }

    public void setGraphColor(Color graphColor) {
        this.graphColor = graphColor;
    }

    /** Creates new form Graph */
    public Graph(int awidth, int aheight) {
        Dimension dim = new Dimension(awidth, aheight);
        initComponents();
        setBackground(Color.black);
        
        setMinimumSize(dim);
        setSize(dim);
        setPreferredSize(dim);
        setMaximumSize(dim);
        
        
    }
    
    public void showValues(List<Float> data){
        if(data != null){
        List<Float> tmp = new ArrayList<Float>(data);
        if(tmp.size() > steps){
            int num = tmp.size() - steps - 1;
            for(int i = 0; i < num; i++){
                tmp.remove(0);
            }
        }
        this.data = tmp;
        }
        else
            this.data = data;
        
        repaint();
    }
    
    private void drawDashed(Graphics gr, Color col, int x, int y, int x2, int y2){
        gr.setColor(col);
        int step = (x2 - x) / 51;
        for(int i = 0; i < 51; i++){
            if(i % 2 == 0){
                gr.drawLine(x + step * i, y, x + step * (i+1), y);
            }
        }
    }
           
    @Override
    protected void paintComponent(Graphics gr){
        int height = this.getHeight() - 1;
        
        gr.setColor(graphBgColor);
        //gr.fillRect(this.getX(), this.getY(), this.getWidth(), height);
        
        gr.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        gr.setColor(Color.black);
        gr.drawLine(0, height, this.getWidth(), height);
       
        gr.setColor(graphColor);
        
        if(data != null && data.size() > 0){
            int step = this.getWidth() / data.size();
            float maxValue = getDataMaxValue();
            if(maxValue > max){
                max = maxValue;
            }
            else{
                maxValue = max;
            }
            double minValue = getDataMinValue();
            int normHeight = (int)( (double)(height) / (maxValue - min));
            //double diff = max - min;
            //int normHeight = (int)( (double)(height) / diff);
            
            
            // draw target line
            int y = height - (int)((targetValue - min) * normHeight);
            drawDashed(gr, Color.yellow, 0, y, this.getWidth(), y);
            
            // draw values
            P2D point = null;
            gr.setColor(graphColor);

            int idx = data.size() > steps ? data.size() - steps : 0;
            for(int i = idx; i < data.size(); i++){
              P2D p = new P2D(i * step, (int)((data.get(i) - min) * normHeight));

                if(style == STYLE_LINES){
                    if(point == null){
                        point = p;
                    }else{
                        gr.drawLine(point.x, height - point.y, p.x, height - p.y);
                        point = p;
                    }
                }
                else if(style == STYLE_RECTS){
                    if(point == null && i == idx){
                        point = p;
                        gr.drawLine(0, height - p.y, p.x + step/2, height - p.y);
                    }else{
                        gr.drawLine(point.x + step/2, height - point.y, p.x - step/2, height - p.y);
                        gr.drawLine(p.x - step/2, height - p.y, p.x + step/2, height - p.y);
                        point = p;
                    }
                }
            }            
        }else{
            gr.drawLine(0, 0, this.getWidth(), height);
        }
    }
    
    private float getDataMaxValue(){
        float res = Float.MIN_VALUE;
        for(Float gd: data){
            if(gd > res){
                res = gd;
            }
        }
        return res;
    }

    private double getDataMinValue()
    {
        double res = Double.MAX_VALUE;
        for(Float gd: data){
            if(gd < res){
                res = gd;
            }
        }
        return res;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(255, 255, 255));

        setLayout(new java.awt.BorderLayout());

    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public static void main(String... str){
        /*
        ArrayList<GraphData> list = new ArrayList<GraphData>();
        for(int i = 0; i < 100; i++){
            list.add(new GraphData(null, Math.random()));
        }
        
        JFrame frame = new JFrame("GUI Test");
        frame.setSize(800, 200);
        frame.setResizable(true);
        
        Graph g = new Graph();
        g.setTargetValue(0.2);
        g.setStyle(STYLE_RECTS);
        g.showValues(list);
        
        frame.getContentPane().add(g);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        */
    }
}
