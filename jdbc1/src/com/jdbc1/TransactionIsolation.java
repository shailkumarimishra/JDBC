package com.jdbc1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransactionIsolation {
public static void main(String[] args) {
	ExecutorService srv=Executors.newFixedThreadPool(1);
	srv.execute(new Shail());
	srv.execute(new Anjali());
	
	
	
}
}
