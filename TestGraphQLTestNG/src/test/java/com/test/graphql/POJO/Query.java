package com.test.graphql.POJO;

public class Query {

    private String query;
    private Object variables;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Object getVariableVal() {
        return variables;
    }

    public void setVariableVal(Object variables) {
        this.variables = variables;
    }

	/*
	 * @Override public String toString() { return "Query{" + "query='" + query +
	 * '\'' + ", variableVal=" + variableVal + '}'; }
	 */
}
