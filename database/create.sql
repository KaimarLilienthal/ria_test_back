-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-05 14:13:56.528

-- tables
-- Table: event
CREATE TABLE event (
                       id serial  NOT NULL,
                       event_name varchar(50)  NOT NULL,
                       event_place varchar(50)  NOT NULL,
                       event_date date  NOT NULL,
                       event_info varchar(1000)  NOT NULL,
                       status char(1)  NOT NULL,
                       CONSTRAINT event_pk PRIMARY KEY (id)
);

-- Table: participant
CREATE TABLE participant (
                             id serial  NOT NULL,
                             person_firstname varchar(255)  NULL,
                             person_lastname varchar(255)  NULL,
                             person_id_code varchar(11)  NULL,
                             person_payment_type varchar(255)  NULL,
                             person_info varchar(1500)  NULL,
                             company_name varchar(255)  NULL,
                             company_registration_code varchar(50)  NULL,
                             company_participant_sum varchar(50)  NULL,
                             company_payment_type varchar(255)  NULL,
                             company_info varchar(5000)  NULL,
                             event_id int  NOT NULL,
                             status char(1)  NOT NULL,
                             CONSTRAINT participant_pk PRIMARY KEY (id)
);

-- Create a function to update the status
CREATE OR REPLACE FUNCTION update_event_status() RETURNS TRIGGER AS $$
BEGIN
    -- If the event_date is in the past, set status to 'P' (past)
    IF NEW.event_date < CURRENT_DATE THEN
        NEW.status = 'P';
    ELSE
        NEW.status = 'F'; -- Set status to 'F' (future)
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Create a trigger to call the function before INSERT or UPDATE on the event table
CREATE TRIGGER event_status_trigger
    BEFORE INSERT OR UPDATE ON event
    FOR EACH ROW
EXECUTE FUNCTION update_event_status();

-- foreign keys
-- Reference: participant_event (table: participant)
ALTER TABLE participant ADD CONSTRAINT participant_event
    FOREIGN KEY (event_id)
        REFERENCES event (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.
