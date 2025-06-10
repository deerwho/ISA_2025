'use client'
import {useEffect, useState} from "react";
import Link from "next/link";
import {get} from "@/core/httpClient";
import {useForm} from "react-hook-form";
import {Button, Col, Row} from "reactstrap";
import {post} from "../../../core/httpClient";
import {regexCSS} from "next/dist/build/webpack/loaders/utils";
export default function kreirajKorisnika() {
    /*const [counter, setCounter]=useState(0);
    const [loading, setLoading]=useState(false);
    const [data, setData]=useState();

    const vratiIme =async ()=>{
        setLoading(true);

        let result=await get("/korisnik/vrati-ime");
        setData(result.data);
        setLoading(false);
    }

    useEffect(() => {
        vratiIme();
    }, []);*/

    const {register,
        watch,
        handleSubmit,
        formState:{errors}} = useForm();//kad dodje do promene registration pokrece se watch metoda
    //console.log(watch());                                 //ako postoje greske u errors, handleSubmit se ne poziva

    return (
        <>
            {/*{loading===true ? <h1>Loading...</h1>:(
                <>
                    <h1>{data}</h1>
                    <h1>{counter}</h1>
                    <br></br>

                    <button onClick={() => setCounter(counter + 1)}>+1</button>

                    <h1>Kreiranje Korisnika</h1>
                    <br></br>
                    <Link href="/korisnik/lista">Lista</Link>
                </>
            )}*/}
            <Row className="mb-3">{/*reactstrap*/}
                <Col md={6}>
                    <input type="text" className="form-control" placeholder="Ime" {...register("ime",{
                        required: "Ime je obavezno!"
                    })}></input>
                    {errors && errors.ime && (<span className="text-danger">{errors.ime.message}</span>)}

                </Col>
                <Col md={6}>
                    <input type="text" className="form-control" placeholder="Prezime" {...register("prezime", {
                        required: "Prezime je obavezno!"})}></input>
                    {errors && errors.prezime && (<span className="text-danger">{errors.prezime.message}</span>)}
                </Col>
            </Row>
            <Row className="mb-3">
                <Col md={6}>
                    <input type="text" className="form-control" placeholder="Godine"{...register("godine",{
                        required: "Godine su obavezne!",
                        validate: (value)=>{
                            if(!(/^[0-9]*$/.test(value)))
                                return "Godine upisati brojevima."
                            }
                        })}></input>
                    {errors && errors.godine && (<span className="text-danger">{errors.godine.message}</span>)}
                </Col>
                <Col md={6}>
                    <input type="email" className="form-control" placeholder="Email"{...register("email",{
                        required: "Email je obavezan!",
                        pattern: {
                            value: /^[^\s@]+@[^\s@]+\.[^\s@]+$/,
                            message: "Pogrešan format za email!"
                        }
                        })}></input>
                    {errors && errors.email && (<span className="text-danger">{errors.email.message}</span>)}
                </Col>
            </Row>
            <Row>
                <Col md={12} className="d-flex justify-content-center">
                    <Button className="btn btn-primary" onClick={()=>{
                        //console.log(errors);
                        handleSubmit(async (data)=>{
                            await post("korisnik/kreiraj-korisnika", data)
                        })();
                    }}>Registruj se</Button>
                </Col>
            </Row>


        </>
    );
}
