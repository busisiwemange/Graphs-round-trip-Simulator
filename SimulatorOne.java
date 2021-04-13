import java.io.*;
import java.util.*;

public class SimulatorOne{

 public static void main( String [ ] args ) throws IOException{
        
        Graph g = new Graph();
        //FileReader fr = new FileReader("PartOne.txt");
        Scanner s = new Scanner( System.in );
        
        // Read the edges and insert
        // String line;
        int numOfNodes;
        int numOfVictims;
        int numOfHosp;
        String[] hospitals = {};
        String[] victims = {};
        String line;
        
     
        
            numOfNodes = Integer.parseInt(s.nextLine( ));
            String[] edgeAr;
            String source;
            int destination;
            int cost;
            
            
            //read and add edges 
            for(int i = 0; i< numOfNodes; i++){
               line = s.nextLine();
               edgeAr  = line.split(" ");
               source = edgeAr[0];
               destination  = 1;
               
               
               cost = 2;
               
               for(int j=0; j< (edgeAr.length-1)/2;j++){
                  g.addEdge(edgeAr[0],edgeAr[destination],Integer.parseInt(edgeAr[cost]));
                  cost+=2;
                  destination+=2;
               }
               
                   
             }
             
             
             // read and store hospital nodes
            // System.out.println("Number of hospitals");
             numOfHosp = Integer.parseInt(s.nextLine());   
             
             // System.out.println("hospital node");
              String line1 = s.nextLine();
              
               hospitals  = line1.split(" ");
             
             
             // read and store victim nodes
            // System.out.println("Number of victims");
             numOfVictims = Integer.parseInt(s.nextLine());      
             
               //System.out.println("victim  node");

               String line2 = s.nextLine();
               victims = line2.split(" ");
             
       
        
      
        // calculating shortest path for each victim and print the path
        ArrayList<Double> costs = new ArrayList<Double>();
        ArrayList<String> path = new ArrayList<String>();
        
        for(String v : victims){
        
        System.out.println("victim "+ v);
            for(String h: hospitals){
            
               g.dijkstra(h);
               double go = g.printPath(v);
               //System.out.print(g.track);
               g.dijkstra(v);
               double back = g.printPath(h);
               
               path.add(g.track+h);
               costs.add(go+back);
               
               //g.printPath();
                g.track = "";           
            }
            //take the minimum
            double min = Collections.min(costs);
            
            
            for (int z = 0;z<costs.size();z++)
            {
              if (costs.get(z) == min){
                //System.out.println(num);
                //int num = costs.indexOf(min);
                String[] splt = path.get(z).split(" ");
            
            System.out.println("hospital "+splt[0]);
            System.out.println(path.get(z));
              }
            }
            
            costs.clear();
            path.clear();
        }
        
        
                     

     } }  
        
        
        
        
/*
5
0 1 98 2 5 3 16 4 16
1 0 13 2 47 3 3 4 40
2 0 71 1 51 3 43 4 30
3 0 20 1 94 4 46
4 0 1 1 10 2 28 3 15
2
2 3
2
0 1
*/     
        
        
        
        


       
    
   
      

 