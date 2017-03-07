package service;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Userbean;

import dao.registerdao;

public class registerservice {
	
	registerdao rd=  new registerdao();
	 ArrayList<Userbean> ar= new ArrayList<Userbean>();
	public boolean Insert(Userbean ub)
	{
	  if(rd.register(ub))
		  return true;
	  else
		  return false;
		
	}
	public boolean delete(Userbean ub)
	{
	  if(rd.delete(ub))
		  return true;
	  else
		  return false;
		
	}
	
	public JSONArray Display()
	{
		JSONArray ja = new JSONArray();
		try
		{
			ar=rd.DisplayDetails();
			JSONObject jo = null;
	
	
     for(Userbean st:ar)
     {
   	 		jo = new JSONObject();
				jo.put("FirstName",st.getFirstName());
				jo.put("LastName",st.getLastName());
				jo.put("Email",st.getEmail());
				jo.put("Password",st.getPassword());
				jo.put("Repassword", st.getRepassword());
				jo.put("Country", st.getConutry());
				jo.put("Gender", st.getGender());
				
				ja.put(jo);
			}
    
		}
		catch(Exception e)
		{
		}
		  return ja;  
	}

}
