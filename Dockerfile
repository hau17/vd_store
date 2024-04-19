FROM ubuntu:latest
LABEL authors="congh"

ENTRYPOINT ["top", "-b"]