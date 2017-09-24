import React from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';
import moment from 'moment';

class Card extends React.Component {
    render() {
        return (
            <div className="card bg-light mb-3 carta">
                <div className="card-block">
                    <div className="card-header titulo">{this.props.price}</div>
                    <p className="card-text texto">{moment().fromNow()}</p>
                </div>
            </div>
        );
    }
}

class CardsContainer extends React.Component {
    constructor() {
        super();
        this.state = {
            cards: ["0.000"],
        };
    }

    componentDidMount() {
        axios.get('/Cotizacion/' + this.props.currency)
            .then((response) => {
                this.setState(
                    {cards: [response.data.buyPrice]});
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    getCards() {
        return this.state.cards.map(card => <Card price={card}/>);
    }

    render() {
        return (
            <div className="col-md-2">
                <h5 className="titulo">{this.props.currency}</h5>
                {this.getCards()}
            </div>
        );
    }
}

class CurrencyBoard extends React.Component {
    render() {
        return (
            <div className="row">
                <CardsContainer currency="Dolar"/>
                <CardsContainer currency="Euro"/>
                <CardsContainer currency="Real"/>
            </div>
        );
    }
}

const app = document.getElementById('root');
ReactDOM.render(
    <CurrencyBoard/>, app
)
;