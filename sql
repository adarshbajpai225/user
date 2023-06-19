SELECT *
FROM user 
JOIN address ON user.id = address.userid
WHERE address.state = "up";
