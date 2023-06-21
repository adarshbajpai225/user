SELECT *
FROM user 
JOIN address ON user.id = address.userid
WHERE address.state = "up"and address.city="Noida";


	id	firstname	lastname	email	      password	status	ad_id	userid	houseno	addressline1	addressline2	city	state	country	pincode
	8    	adarsh0 	bajpai0	aadi@gmail.com	13454    	0      	47	8	        104  	noida	              gbn	    Noida	up	india	262013
