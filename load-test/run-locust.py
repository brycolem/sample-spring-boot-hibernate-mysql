import random
from locust import HttpUser, task, between

# Variables
concurrent_users = 255
ramp_up_time = 5
total_duration = 18

# Generate the URL list
url_list = [
    "http://172.21.118.12:8080/api/v1/article"
] + [f"http://172.21.118.12:8080/api/v1/article/{i}" for i in range(13, 45)]


class MyUser(HttpUser):
    # Set the delay between requests to 0.2 seconds
    wait_time = between(0.2, 0.2)

    @task
    def make_requests(self):
        url = random.choice(url_list)
        self.client.get(url)


# Define your own custom Locust command-line options
def setup_parser(parser):
    parser.add_argument(
        "--users",
        type=int,
        default=concurrent_users,
        help="Number of concurrent users (default: %(default)s)",
    )
    parser.add_argument(
        "--ramp-up",
        type=int,
        default=ramp_up_time,
        help="Ramp-up time in seconds (default: %(default)s)",
    )
    parser.add_argument(
        "--duration",
        type=int,
        default=total_duration,
        help="Total test duration in seconds (default: %(default)s)",
    )


def parse_options(options):
    global concurrent_users, ramp_up_time, total_duration
    concurrent_users = options.users
    ramp_up_time = options.ramp_up
    total_duration = options.duration


# Register the custom command-line options
if __name__ == "__main__":
    from locust.main import main

    main(custom_parser=setup_parser, parsed_options_callback=parse_options)
