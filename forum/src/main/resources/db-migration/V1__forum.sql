--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;
SET default_tablespace = '';
SET default_table_access_method = heap;
--
-- Name: comment; Type: TABLE; Schema: public; Owner: postgres
--
CREATE TABLE public.comment (
                                comment_pk bigint NOT NULL,
                                content_comment text,
                                user_pk bigint,
                                thread_pk bigint,
                                enable_comment boolean
);
ALTER TABLE public.comment OWNER TO postgres;
--
-- Name: comment_comment_pk_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--
CREATE SEQUENCE public.comment_comment_pk_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE public.comment_comment_pk_seq OWNER TO postgres;
--
-- Name: comment_comment_pk_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--
ALTER SEQUENCE public.comment_comment_pk_seq OWNED BY public.comment.comment_pk;
--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--
CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE public.hibernate_sequence OWNER TO postgres;
--
-- Name: image; Type: TABLE; Schema: public; Owner: postgres
--
CREATE TABLE public.image (
                              image_pk bigint NOT NULL,
                              thread_pk bigint,
                              image_thread text,
                              comment_pk bigint,
                              image_comment text,
                              enable_image boolean
);
ALTER TABLE public.image OWNER TO postgres;
--
-- Name: image_image_pk_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--
CREATE SEQUENCE public.image_image_pk_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE public.image_image_pk_seq OWNER TO postgres;
--
-- Name: image_image_pk_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--
ALTER SEQUENCE public.image_image_pk_seq OWNED BY public.image.image_pk;
--
-- Name: likes; Type: TABLE; Schema: public; Owner: postgres
--
CREATE TABLE public.likes (
                              like_pk bigint NOT NULL,
                              comment_pk bigint,
                              user_pk bigint,
                              thread_pk bigint,
                              enable_like boolean
);
ALTER TABLE public.likes OWNER TO postgres;
--
-- Name: likes_like_pk_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--
CREATE SEQUENCE public.likes_like_pk_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE public.likes_like_pk_seq OWNER TO postgres;
--
-- Name: likes_like_pk_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--
ALTER SEQUENCE public.likes_like_pk_seq OWNED BY public.likes.like_pk;
--
-- Name: medicine; Type: TABLE; Schema: public; Owner: postgres
--
CREATE TABLE public.medicine (
                                 dealer_pk bigint,
                                 medicine_pk bigint NOT NULL,
                                 name_medicine text,
                                 where_production text,
                                 price text,
                                 effect text,
                                 details_medicine text,
                                 enable_medicine boolean
);
ALTER TABLE public.medicine OWNER TO postgres;
--
-- Name: medicine_medicine_pk_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--
CREATE SEQUENCE public.medicine_medicine_pk_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE public.medicine_medicine_pk_seq OWNER TO postgres;
--
-- Name: medicine_medicine_pk_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--
ALTER SEQUENCE public.medicine_medicine_pk_seq OWNED BY public.medicine.medicine_pk;
--
-- Name: post_thread; Type: TABLE; Schema: public; Owner: postgres
--
CREATE TABLE public.post_thread (
                                    thread_pk bigint NOT NULL,
                                    title_thread text,
                                    time_post_thread timestamp without time zone,
                                    content_of_thread text,
                                    post_topic_pk bigint,
                                    user_pk bigint,
                                    enable_post_thread boolean,
                                    approved boolean
);
ALTER TABLE public.post_thread OWNER TO postgres;
--
-- Name: post_thread_thread_pk_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--
CREATE SEQUENCE public.post_thread_thread_pk_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE public.post_thread_thread_pk_seq OWNER TO postgres;
--
-- Name: post_thread_thread_pk_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--
ALTER SEQUENCE public.post_thread_thread_pk_seq OWNED BY public.post_thread.thread_pk;
--
-- Name: post_topic; Type: TABLE; Schema: public; Owner: postgres
--
CREATE TABLE public.post_topic (
                                   post_topic_pk bigint NOT NULL,
                                   name_topic text,
                                   enable_post_topic boolean
);
ALTER TABLE public.post_topic OWNER TO postgres;
--
-- Name: post_topic_post_topic_pk_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--
CREATE SEQUENCE public.post_topic_post_topic_pk_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER TABLE public.post_topic_post_topic_pk_seq OWNER TO postgres;
--
-- Name: post_topic_post_topic_pk_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--
ALTER SEQUENCE public.post_topic_post_topic_pk_seq OWNED BY public.post_topic.post_topic_pk;
--
-- Name: rep_comment; Type: TABLE; Schema: public; Owner: postgres
--
CREATE TABLE public.rep_comment (
                                    comment_rep_pk bigint NOT NULL,
                                    content_comment_rep text,
                                    user_pk bigint,
                                    comment_pk bigint,
                                    enable_rep_comment boolean
);

ALTER TABLE public.rep_comment OWNER TO postgres;

--
-- Name: rep_comment_comment_rep_pk_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rep_comment_comment_rep_pk_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rep_comment_comment_rep_pk_seq OWNER TO postgres;

--
-- Name: rep_comment_comment_rep_pk_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.rep_comment_comment_rep_pk_seq OWNED BY public.rep_comment.comment_rep_pk;


--
-- Name: user_medicine; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_medicine (
                                      id bigint NOT NULL,
                                      medicine_pk bigint,
                                      user_pk bigint
);


ALTER TABLE public.user_medicine OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
                              user_pk bigint NOT NULL,
                              email text,
                              password text,
                              username text,
                              role text,
                              phone_number text,
                              address text,
                              date_of_birth date,
                              ban_account boolean,
                              img_avatar text,
                              description text,
                              created_date date,
                              expire date,
                              enable_users boolean
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_user_pk_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_user_pk_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_user_pk_seq OWNER TO postgres;

--
-- Name: users_user_pk_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_user_pk_seq OWNED BY public.users.user_pk;


--
-- Name: comment comment_pk; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment ALTER COLUMN comment_pk SET DEFAULT nextval('public.comment_comment_pk_seq'::regclass);


--
-- Name: image image_pk; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image ALTER COLUMN image_pk SET DEFAULT nextval('public.image_image_pk_seq'::regclass);


--
-- Name: likes like_pk; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.likes ALTER COLUMN like_pk SET DEFAULT nextval('public.likes_like_pk_seq'::regclass);


--
-- Name: medicine medicine_pk; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicine ALTER COLUMN medicine_pk SET DEFAULT nextval('public.medicine_medicine_pk_seq'::regclass);


--
-- Name: post_thread thread_pk; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post_thread ALTER COLUMN thread_pk SET DEFAULT nextval('public.post_thread_thread_pk_seq'::regclass);


--
-- Name: post_topic post_topic_pk; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post_topic ALTER COLUMN post_topic_pk SET DEFAULT nextval('public.post_topic_post_topic_pk_seq'::regclass);


--
-- Name: rep_comment comment_rep_pk; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rep_comment ALTER COLUMN comment_rep_pk SET DEFAULT nextval('public.rep_comment_comment_rep_pk_seq'::regclass);


--
-- Name: users user_pk; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN user_pk SET DEFAULT nextval('public.users_user_pk_seq'::regclass);


--
-- Name: comment comment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (comment_pk);


--
-- Name: image image_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT image_pkey PRIMARY KEY (image_pk);


--
-- Name: likes likes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.likes
    ADD CONSTRAINT likes_pkey PRIMARY KEY (like_pk);


--
-- Name: medicine medicine_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicine
    ADD CONSTRAINT medicine_pkey PRIMARY KEY (medicine_pk);


--
-- Name: post_thread post_thread_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post_thread
    ADD CONSTRAINT post_thread_pkey PRIMARY KEY (thread_pk);


--
-- Name: post_topic post_topic_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post_topic
    ADD CONSTRAINT post_topic_pkey PRIMARY KEY (post_topic_pk);


--
-- Name: rep_comment rep_comment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rep_comment
    ADD CONSTRAINT rep_comment_pkey PRIMARY KEY (comment_rep_pk);


--
-- Name: user_medicine user_medicine_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_medicine
    ADD CONSTRAINT user_medicine_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_pk);


--
-- Name: comment comment_thread_pk_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_thread_pk_fkey FOREIGN KEY (thread_pk) REFERENCES public.post_thread(thread_pk);


--
-- Name: comment comment_user_pk_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_user_pk_fkey FOREIGN KEY (user_pk) REFERENCES public.users(user_pk);


--
-- Name: image image_comment_pk_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT image_comment_pk_fkey FOREIGN KEY (comment_pk) REFERENCES public.comment(comment_pk);


--
-- Name: image image_thread_pk_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT image_thread_pk_fkey FOREIGN KEY (thread_pk) REFERENCES public.post_thread(thread_pk);


--
-- Name: likes likes_comment_pk_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.likes
    ADD CONSTRAINT likes_comment_pk_fkey FOREIGN KEY (comment_pk) REFERENCES public.comment(comment_pk);


--
-- Name: likes likes_thread_pk_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.likes
    ADD CONSTRAINT likes_thread_pk_fkey FOREIGN KEY (thread_pk) REFERENCES public.post_thread(thread_pk);


--
-- Name: likes likes_user_pk_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.likes
    ADD CONSTRAINT likes_user_pk_fkey FOREIGN KEY (user_pk) REFERENCES public.users(user_pk);


--
-- Name: medicine medicine_dealer_pk_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicine
    ADD CONSTRAINT medicine_dealer_pk_fkey FOREIGN KEY (dealer_pk) REFERENCES public.users(user_pk);


--
-- Name: post_thread post_thread_post_topic_pk_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post_thread
    ADD CONSTRAINT post_thread_post_topic_pk_fkey FOREIGN KEY (post_topic_pk) REFERENCES public.post_topic(post_topic_pk);


--
-- Name: post_thread post_thread_user_pk_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post_thread
    ADD CONSTRAINT post_thread_user_pk_fkey FOREIGN KEY (user_pk) REFERENCES public.users(user_pk);


--
-- Name: rep_comment rep_comment_comment_pk_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rep_comment
    ADD CONSTRAINT rep_comment_comment_pk_fkey FOREIGN KEY (comment_pk) REFERENCES public.comment(comment_pk);


--
-- Name: rep_comment rep_comment_user_pk_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rep_comment
    ADD CONSTRAINT rep_comment_user_pk_fkey FOREIGN KEY (user_pk) REFERENCES public.users(user_pk);


--
-- PostgreSQL database dump complete
--

