#!/bin/sh

set -e

INIT_DB="src/main/resources/init-db"

#Postgres
until psql -h postgres -U postgres -w -c "SELECT 1;"; do
  >&2 echo "Postgres is unavailable - sleeping"
  sleep 3
done
>&2 echo "Postgres is up"
psql -h postgres -U postgres -w  -c 'CREATE DATABASE "testpgsql" WITH ENCODING='UTF8' CONNECTION LIMIT=-1;'
psql -h postgres -U postgres -d testpgsql -w -f $INIT_DB/postgres/shema.sql
psql -h postgres -U postgres -d testpgsql -w -f $INIT_DB/postgres/seeds.sql
