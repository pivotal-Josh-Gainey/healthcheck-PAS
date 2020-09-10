# healthcheck-PAS

Simple application to simulate random failed health checks.

The end point is /health-random-fail

It generates a random number between 0-4 and if it is 3 it will return a 401, all others return a 200.

Two other endpoints are:

/health-print-ip  - this will show the silk address of the healthcheck container and log it.

/health-print-all - this will show all other headers for the healthcheck request and log it.

/health - this will sleep for 5 seconds then return a HTTP status of 200.
