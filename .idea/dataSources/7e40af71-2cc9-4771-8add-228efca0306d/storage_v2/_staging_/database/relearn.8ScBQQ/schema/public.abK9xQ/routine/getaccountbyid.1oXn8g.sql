create function getaccountbyid(p_id integer) returns SETOF accounts
    language plpgsql
as
$$
begin
    return query
	select id, username, phone_number, balance, card_number
	from accounts
	where id = p_id;
end;
$$;

alter function getaccountbyid(integer) owner to postgres;


select * from getAccountById(13 );

