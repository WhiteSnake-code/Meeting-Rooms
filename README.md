# 📌 Room Booking API

REST API to **manage meeting room bookings**.  
It allows creating rooms, making reservations, and retrieving existing bookings while preventing **time conflicts**.

---

## 🧰 Technologies

- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA (Hibernate)  
- MySQL Database (for development)  
- Lombok (optional)  
- Gradle  

---

## ⚡ Features

## 🏢 Rooms

- Create a room  
- List all rooms  
- Get a room by ID  

## 📅 Bookings

- Create a booking  
- List all bookings  
- List bookings by room  

## 🔒 Business Rule

- A booking cannot be created if there is another booking in the same room that overlaps with the requested time range.
