-- Exercise 1: User Upcoming Events
SELECT u.full_name, e.title, e.city, u.registration_date, e.start_date, e.end_date 
FROM users AS u
JOIN registrations AS r ON u.user_id = r.user_id
JOIN events AS e ON r.event_id = e.event_id
WHERE e.status = 'upcoming' AND u.city = e.city
ORDER BY e.start_date;

-- Exercise 2: Top Rated Events
SELECT e.title, e.city, e.start_date, AVG(f.rating) AS avg_rating, COUNT(*) as feedback_count
FROM events AS e
JOIN feedback AS f ON e.event_id = f.event_id
GROUP BY e.event_id, e.title, e.city, e.start_date
HAVING COUNT(*)  >= 10
ORDER BY avg_rating DESC;

-- Exercise 3: Inactive Users
SELECT u.user_id, u.full_name 
FROM users AS u
WHERE u.user_id NOT IN (
	SELECT DISTINCT user_id 
    FROM registrations
    WHERE registration_date >= CURDATE() - INTERVAL 90 DAY
);

-- Exercise 4: Peak Session Hours
SELECT e.event_id, e.title, COUNT(*) AS session_count
FROM events AS e
JOIN sessions AS s ON e.event_id = s.event_id
WHERE TIME(s.start_time) BETWEEN '10:00:00' AND '12:00:00'
GROUP BY e.event_id, e.title;

-- Exercise 5: Most Active Cities
SELECT u.city, COUNT(DISTINCT r.user_id) AS total_registrations
FROM users AS u
JOIN registrations AS r ON u.user_id = r.user_id
GROUP BY u.city
LIMIT 5;

-- Exercise 6: Event Resource Summary
SELECT e.event_id, e.title, COUNT(rs.resource_id) AS total_resources
FROM events as e
JOIN resources AS rs ON e.event_id = rs.event_id
GROUP BY e.event_id, e.title;

-- Exercise 7: Low Feedback Alerts
SELECT u.full_name, e.title, f.rating, f.comments
FROM feedback AS f
JOIN users AS u ON f.user_id = u.user_id
JOIN events AS e ON f.event_id = e.event_id
WHERE f.rating <= 3;

-- Exercise 8: Sessions per Upcoming Event
SELECT e.title, COUNT(*) AS session_count
FROM events AS e
JOIN sessions AS s ON e.event_id = s.event_id
WHERE e.status = 'upcoming'
GROUP BY e.event_id, e.title;

-- Exercise 9: Organizer Event Summary
SELECT u.full_name, e.title, e.status, COUNT(e.event_id) AS total_event
FROM events AS e
JOIN users AS u ON u.user_id = e.organizer_id
GROUP BY u.user_id, u.full_name, e.title, e.status;

-- Exercise 10: Feedback Gap
SELECT DISTINCT e.event_id, e.title
FROM events AS e
JOIN registrations AS r ON r.event_id = e.event_id
LEFT JOIN feedback AS f ON e.event_id = f.event_id
WHERE f.feedback_id IS NULL;

-- Exercise 11: Daily New User Count
SELECT registration_date, COUNT(user_id) AS new_user_count
FROM users
WHERE registration_date >= CURDATE() - INTERVAL 7 DAY
GROUP BY registration_date
ORDER BY registration_date;

-- Exercise 12: Event with Maximum Sessions
SELECT e.event_id, e.title, COUNT(s.session_id) as total_sessions
FROM events AS e
JOIN sessions AS s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title
ORDER BY total_sessions DESC
LIMIT 1;

-- Exercise 13: Average Rating per CIty
SELECT e.city, AVG(f.rating) AS average_rating_per_city, COUNT(f.feedback_id) AS total_feedbacks
FROM events AS e
JOIN feedback AS f ON e.event_id = f.event_id
GROUP BY e.city;

-- Exercise 14: Most Registered Events
SELECT e.event_id, e.title, COUNT(r.user_id) AS total_registration
FROM events AS e
JOIN registrations AS r ON e.event_id = r.event_id
GROUP BY e.event_id, e.title
ORDER BY total_registration DESC
LIMIT 3;

-- Exercise 15: Event Session Time Conflict
SELECT
	e.title AS event_name,
    s1.title AS session_1,
    s1.start_time,
    s1.end_time,
    s2.title AS session_2,
    s2.start_time,
    s2.end_time
FROM sessions s1
JOIN sessions s2 
    ON s1.event_id = s2.event_id
    AND s1.session_id < s2.session_id
    AND s1.start_time < s2.end_time
    AND s1.end_time > s2.start_time
JOIN events e ON e.event_id = s1.event_id;

-- Exercise 16: Unregistered Active Users
SELECT u.user_id, u.full_name, u.registration_date
FROM users AS u
LEFT JOIN registrations AS r ON u.user_id = r.user_id
WHERE u.registration_date >= CURDATE() - INTERVAL 30 DAY
	AND r.registration_id IS NULL;

-- Exercise 17: Multi-Session Speakers
SELECT speaker_name, title, COUNT(*) AS total_sessions
FROM sessions
GROUP BY speaker_name, title
HAVING total_sessions > 1;

-- Exercise 18: Resource Availability Check
SELECT e.event_id, e.title
FROM events AS e
LEFT JOIN resources AS re ON e.event_id = re.event_id
WHERE re.resource_id IS NULL;

-- Exercise 19: Completed Events with Feedback Summary
SELECT 
	e.event_id, 
    e.title, 
	COUNT(DISTINCT r.registration_id) AS total_registrations, 
    AVG(f.rating) AS average_feedback
FROM events AS e
JOIN registrations AS r ON e.event_id = r.event_id
JOIN feedback AS f ON e.event_id = f.event_id
WHERE e.status = 'completed'
GROUP BY e.event_id, e.title;

-- Exercise 20: User Engagement Index
SELECT 
	u.user_id, 
    u.full_name,
    COUNT(DISTINCT r.registration_id) AS events_attended,
    COUNT(DISTINCT f.feedback_id) AS feedbacks_submitted
FROM users AS u
LEFT JOIN registrations AS r ON u.user_id = r.user_id
LEFT JOIN feedback AS f ON f.user_id = r.user_id
GROUP BY u.user_id, u.full_name;

-- Exercise 21: Top Feedback Providers
SELECT u.user_id, u.full_name, COUNT(f.feedback_id) AS feedback_count
FROM feedback AS f
JOIN users AS u ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name
ORDER BY feedback_count DESC
LIMIT 5;

-- Exercise 22: Duplicate Registrations Check
SELECT r.user_id, u.full_name,  r.event_id, COUNT(*) AS duplicate_count
FROM registrations AS r
JOIN users AS u ON u.user_id = r.user_id
GROUP BY r.user_id, u.full_name, r.event_id
HAVING COUNT(*) > 1;

-- Exercise 23: Registration Trends (Event Registrations)
SELECT 
	DATE_FORMAT(registration_date, '%Y-%m') AS month, 
	COUNT(registration_id) AS registration_count
FROM registrations
WHERE registration_date >= CURDATE() - INTERVAL 12 MONTH
GROUP BY DATE_FORMAT(registration_date, '%Y-%m')
ORDER BY month;

-- (User Registrations)
SELECT 
	DATE_FORMAT(registration_date, '%Y-%m') AS month,
    COUNT(user_id) AS registration_count
FROM users
WHERE registration_date >= CURDATE() - INTERVAL 12 MONTH
GROUP BY DATE_FORMAT(registration_date, '%Y-%m')
ORDER BY month;

-- Exercise 24: Average Session Duration per Event
SELECT e.event_id, e.title, 
	AVG(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time))
		AS avg_duration
FROM events as e
JOIN sessions as s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title;


-- Exercise 25 : Events Without Sessions
SELECT e.event_id, e.title
FROM events AS e
LEFT JOIN sessions AS s ON e.event_id = s.event_id
WHERE s.session_id IS NULL;
