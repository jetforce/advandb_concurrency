/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dboperations;

/**
 *
 * @author Hannah
 */
public class Query {
    public int place_id;
    public String query;
    
    public Query(String query, int place_id) {
        this.query = query;
        this.place_id = place_id;
    }
}
