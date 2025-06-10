'use client'
import {useEffect, useState} from "react";
import useListData from "@/hooks/useListData";
import DataTable from "react-data-table-component"
import {Spinner} from "reactstrap";

export const tableColumns = [
    {
        name: "Ime",
        selector: (row)=>`${row.ime}`,
        sortable: false,
    },
    {
        name: "Prezime",
        selector: (row)=>`${row.prezime}`,
        sortable: false,
    },
    {
        name: "Godine",
        selector: (row)=>`${row.godine}`,
        sortable: false,
    },
    {
        name: "Email",
        selector: (row)=>`${row.email}`,
        sortable: false,
    }
]

export default function listaKorisnika() {
    const [pageNumber, setPageNumber] = useState(1);
    const [pageSize, setPageSize] = useState(5);
    const {getData, loading, data}=useListData(`korisnik/vrati-sve-korisnikePage?pageNumber=${pageNumber-1}&pageSize=${pageSize}`);

    useEffect(() => {
        getData(`korisnik/vrati-sve-korisnikePage?pageNumber=${pageNumber-1}&pageSize=${pageSize}`)
    }, [pageSize, pageNumber]);

    const handlePageChange = async (page) => {
        setPageNumber(page);//kad se menja pagenumber automatsi se menja url za useListData i ucitavaju se ponovo podaci
    };

    const handlePerRowsChange =async (newPerPage, page) => {
        setPageNumber(page);
        setPageSize(newPerPage);
    }

    return (
        <>

            {/*<h1>Listanje Korisnika</h1>
            <br></br>
            <br></br>*/}

            <DataTable data={data.korisnici}
                       columns={tableColumns}
                       striped={true}
                       noHeader={true}
                       pagination
                       paginationServer
                       /*paginationRowsPerPageOptions={[5,10]}
                       paginationIconNext={true}
                       paginationIconPrevious={true}
                       paginationComponentOptions={true}*/
                       progressPending={loading}
                       paginationTotalRows={data.totalElements}
                       onChangePage={handlePageChange}
                       onChangeRowsPerPage={handlePerRowsChange}
                       progressComponent={<Spinner color="danger">Ocitavanje...</Spinner>}
                       paginationPerPage={5}
                       highlightOnHover
            />

            {/*<br></br>
            <br></br>
            <Link href="/korisnik/kreiranje">Kreiranje</Link>*/}
        </>)
}