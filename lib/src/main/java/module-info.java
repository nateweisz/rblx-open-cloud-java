module me.nateweisz.rblx {
	requires java.net.http;
	requires com.fasterxml.jackson.databind;

	exports me.nateweisz.rblx.api;
	exports me.nateweisz.rblx.api.builders;
	exports me.nateweisz.rblx.api.models;
	exports me.nateweisz.rblx.api.exceptions;
	exports me.nateweisz.rblx.internal;
}
