import React from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';
import moment from 'moment';

class Card extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            price: "0.000",
        };
    }

    componentDidMount() {
        axios.get('/Cotizacion/' + this.props.currency)
            .then((response) => {
                this.setState({price: response.data.buyPrice});
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    render() {
        return (
            <div className="card bg-light mb-3">
                <div className="card-block">
                    <div class="card-header">Price</div>
                    <h4 className="card-title titulo">{this.state.price}</h4>
                    <p className="card-text">{moment().fromNow()}</p>
                </div>
            </div>
        );
    }
}

class CardContainer extends React.Component {
    render() {
        return (
            <div className="row">
                <div id="dolares" className="col-md-2">
                    <h5 className="titulo">DOLAR</h5>
                    <Card currency={'Dolar'}/>
                </div>
                <div id="euros" className="col-md-2">
                    <h5 className="titulo">EURO</h5>
                    <Card currency={'Euro'}/>
                </div>
                <div id="reales" className="col-md-2">
                    <h5 className="titulo">REAL</h5>
                    <Card currency={'Real'}/>
                </div>
            </div>
        );
    }
}

ReactDOM.render(
    <CardContainer/>,
    document.getElementById('root')
);