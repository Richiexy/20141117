package com.xy.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ExtFormResult<T>
{
  private boolean success = true;
  private T data;
  private List<T> results;
  private Map<String, String> errors;
  private String errorMessage;
  private Long totalRecords;

  public String getErrorMessage()
  {
    return this.errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public boolean isSuccess() {
    return this.success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public T getData() {
    return this.data;
  }

  public void setData(T data) {
    this.data = data;
    if (this.results == null)
      this.results = new ArrayList();
    this.results.add(data);
  }

  public Map<String, String> getErrors() {
    return this.errors;
  }

  public void setErrors(Map<String, String> errors) {
    this.errors = errors;
  }

  public void setError(String field, String msg) {
    if (this.errors == null)
      this.errors = new HashMap();
    this.errors.put(field, msg);
  }

  public List<T> getResults() {
    return this.results;
  }

  public void setResults(List<T> results) {
    this.results = results;
  }

  public Long getTotalRecords() {
	return totalRecords;
  }
	
  public void setTotalRecords(Long totalRecords) {
	this.totalRecords = totalRecords;
 }
 
}