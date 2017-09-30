import React from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';
import moment from 'moment';

class Card extends React.Component {
    constructor() {
        super();
        this.state = {
            secondsElapsed: 0,
        };
    }

    componentDidMount() {
        setInterval(
            this.tick.bind(this), 1000
        );
    }

    tick() {
        const prevState = this.state;
        this.setState({
            secondsElapsed: prevState.secondsElapsed + 1
        });
    }

    render() {
        return (
            <div className="card bg-light mb-3 carta">
                <div className="card-block">
                    <div className="card-header titulo">{this.props.price}</div>
                    <p className="card-text texto">{moment().subtract(this.state.secondsElapsed, 'seconds').fromNow()}</p>
                </div>
            </div>
        );
    }
}

class CardsContainer extends React.Component {
    constructor() {
        super();
        this.state = {
            cards: [],
        };
    }

    componentDidMount() {
        this.setPrice();
        setInterval(
            this.setPrice.bind(this), 60000
        );
    }

    setPrice() {
        axios.get('/Cotizacion/' + this.props.currency)
            .then((response) => {
                const prevState = this.state;
                this.setState({
                    cards: prevState.cards.concat([response.data.buyPrice])
                });
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