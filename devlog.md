March 10, 2025 - 12:01 PM

Initial Thoughts
There will be three programs. My understanding of each are listed below:

Logger
	- input filename
	- constantly takes input until QUIT
	- unsure if input commands are limited in options --> graceful exceptions
	- specific write format for log file: YYYY-MM-DD HH:MM [ACTION] MESSAGE

Encryption Program
	- uses Vigenère cipher --> need to understand better
	- takes in 6 possible commands as input
	- graceful handling for ENCRYPT and DECRYPT and ERROR
	- case-insensitive --> convert all inputs to all-caps before use
	- no numbers allowed --> automatic error thrown

Driver Program
	- takes in log file name
	- 2 processes for logger and encryption program
	- 5 command input options
	- uses Process class

-------------------------------------------------------------------