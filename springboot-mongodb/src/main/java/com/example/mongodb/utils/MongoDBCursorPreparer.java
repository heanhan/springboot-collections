/**
 * 
 */
package com.example.mongodb.utils;

import com.mongodb.DBCursor;
 

public interface MongoDBCursorPreparer {
 
    DBCursor prepare(DBCursor cursor);
}