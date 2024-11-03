DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'budget-insights') THEN
        EXECUTE 'CREATE DATABASE budget-insights';
    END IF;
END $$;